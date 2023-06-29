public class Inference{
    float maka[]= new float[9];
    String nama[];
    String nama2[];

    Fuzzification fuzzi1;
    Fuzzification fuzzi2;

    float[] output =  new float[3];

    Inference(String[] nama, Fuzzification fuzzi1, Fuzzification fuzzi2, String[] nama2){
        this.nama = nama;
        this.fuzzi1 = fuzzi1;
        this.fuzzi2 = fuzzi2;
        this.nama2 = nama2;
        inferensi();
        print();
        output();
    }


    public void inferensi(){
        int z=0;
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                if(fuzzi1.output[i]!=0f && fuzzi2.output[j]!=0f){
                    if(fuzzi1.output[i] < fuzzi2.output[j]){
                        maka[z] = fuzzi1.output[i];
                 
                    }
                    else if(fuzzi1.output[i] > fuzzi2.output[j]){
                        maka[z] = fuzzi2.output[j];
                     
                    }
                    
                }
                z++;
    
            }
        }

    }

    public void print(){
        int z=0;
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println(fuzzi1.nama[i]+"("+fuzzi1.output[i]+")\t"+ fuzzi2.nama[j]+"("+fuzzi2.output[j]+")\t\t" + nama2[z]+ "("+maka[z]+")" );
                z++;
            }
            
        }
        
    }


    public void output(){
        
        for(int i =0;i<3;i++){
            for(int j=0;j<9;j++){
                if(nama[i].equals(nama2[j])){
                    if(maka[j]!=0){
                        if(output[i]==0){
                            output[i] = maka[j];
                        }else{
                            if(output[i] < maka[j]){
                                output[i] = maka[j];
                            }
                        }
                
                    }
                }
              
            }
        }

    }
}
