public class Fuzzification {
    
    public float[] abc;
    public String[] nama;
    public float input;
    public float[] output = new float[3];

    
    public Fuzzification(String[] nama, float[] abc,float input) {
        this.nama = nama;
        this.abc = abc;
        this.input = input;
        fuzzifikasi();

    }


    public void fuzzifikasi(){
        float leftC, leftD;
        float centerA, centerB, centerC;
        float rightA, rightB;

        leftC = abc[0];
        leftD = abc[1];

        centerA = abc[0];
        centerB = abc[1];
        centerC = abc[2];

        rightA = abc[1];
        rightB = abc[2];

        if(input <= leftC){
            output[0] = 1;
        }
        else if(input > leftC && input < leftD){
            output[0] = (leftD - input)/(leftD-leftC);
        }
        else if(input>= leftD){
            output[0] = 0;
        }

        if(input > centerA && input <centerB){
            output[1]= (input-centerA)/(centerB-centerA);
        }
        else if(input > centerB && input <centerC){
            output[1]= (centerC-input)/(centerC-centerB);
        }
        else if(input == centerB){
            output[1] = 1;
        }
        else{
            output[1] = 0;
        }


        if(input <= rightA ){
            output[2] = 0;
        }
        else if(input > rightA && input < rightB){
            output[2] = (input - rightA)/(rightB-rightA);
        }
        else if(input >= rightB){
            output[2] = 1;
        }

    }


}


