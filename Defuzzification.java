import java.util.Scanner;

public class Defuzzification{
    float[] inferensi;
    float[][] sample;
    float output;

    Scanner sc = new Scanner(System.in);
    
    public Defuzzification(float[] inferensi,float[][] sample) {
        this.inferensi = inferensi;
        this.sample = sample;
        defuzikasi();
        
    }


    public void defuzikasi(){
        float[] penyebut = new float[3];
        float pembilang = 0f;
        ;
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                if(inferensi[i]!=0){
                    penyebut[i] += sample[i][j]*inferensi[i];

                }

            }
        }

        for(int i =0;i<3;i++){
            pembilang += inferensi[i]*3;
        }

        for(int i =0;i<3;i++){
            if(inferensi[i]!=0){
                output += penyebut[i]/pembilang;
            }
        }
    }

}