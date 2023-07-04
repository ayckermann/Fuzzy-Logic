import java.util.Scanner;

public class Fuzzy{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input 
        String nama1[] = new String[3];
        float abc1[] = new float[3];

        System.out.println("Nama x1 : ");
        for(int i=0;i<3;i++){
            nama1[i] = sc.next();
        }

        System.out.println("Derajat Keanggotaan x1 : ");
        for(int i=0;i<3;i++){
            abc1[i] = sc.nextFloat();
        }

        System.out.println("Nilai x1  : ");
        float input1 = sc.nextFloat();



        String nama2[] = new String[3];   
        float abc2[] =new float[3];
        
        System.out.println("Nama x2 : ");
        for(int i=0;i<3;i++){
            nama2[i] = sc.next();
        }

        System.out.println("Derajat Keanggotaan x2 : ");
        for(int i=0;i<3;i++){
            abc2[i] = sc.nextFloat();
        }


        System.out.println("Nilai x2  : ");
        float input2 = sc.nextFloat();
        
        //fuzzifikasi
        Fuzzification fuzzi1 = new Fuzzification(nama1,abc1, input1);
        Fuzzification fuzzi2 = new Fuzzification(nama2,abc2, input2);

        System.out.println("Fuzzifikasi");
        for(int i =0; i<3;i++){
            if(fuzzi1.output[i]!=0){
                System.out.println("M "+ fuzzi1.nama[i] +"[" + fuzzi1.input + "] = "+ fuzzi1.output[i]);
            }
        }
        for(int i =0; i<3;i++){
            if(fuzzi2.output[i]!=0){
                System.out.println("M "+ fuzzi2.nama[i] +"[" + fuzzi2.input + "] = "+ fuzzi2.output[i]);
            }
        }

        System.out.println();


        //inference
        System.out.println("Inference");
        String maka1[] = new String[3]; 
        System.out.print("Nama y : ");
        for(int i=0;i<3;i++){
            maka1[i] = sc.next();
        }

        String maka2[] = new String[9];

        System.out.println();
        System.out.println("Rules : ");
        int z=0;
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(nama1[i] + "\t"+nama2[j] +"\t");
                maka2[z] = sc.next();
                z++;
            }
        }

        Inference inferensi = new Inference(maka1, fuzzi1,fuzzi2, maka2);


        //defuzzification
        System.out.println();
        System.out.println("Defuzzification");
        for(int i =0;i<3;i++){
            System.out.println(maka1[i]+" = "+inferensi.output[i]);
        }
        System.out.println();


        float[][] sample = new float[3][3];
        
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print("Sample untuk "+maka1[i]+" ke- "+(j+1)+" : ");
                sample[i][j] = sc.nextFloat();
            }
        }
        Defuzzification defuzifikasi =  new Defuzzification(inferensi.output, sample);

        System.out.println("Result : ");
        System.out.println(defuzifikasi.output);


        sc.close();
    }
}