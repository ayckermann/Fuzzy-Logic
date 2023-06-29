

public class Fuzzy{
    public static void main(String[] args) {
        //input 
        String nama1[] = {"jelek","cukup", "bagus"};
        float abc1[] ={2f,2.8f, 3.2f};

        String nama2[] = {"rendah","standar", "tinggi"};   
        float abc2[] ={2.5f,5f,8f};
        
        //fuzzifikasi
        Fuzzification fuzzi1 = new Fuzzification(nama1,abc1, 3f);
        Fuzzification fuzzi2 = new Fuzzification(nama2,abc2, 2.8f);

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
        String maka1[] = {"kurang","lumayan", "layak"}; 
        String maka2[] = {
            "kurang",
            "kurang",
            "kurang",
            "lumayan",
            "kurang",
            "kurang",
            "layak",
            "lumayan",
            "lumayan"
        };
        Inference inferensi = new Inference(maka1, fuzzi1,fuzzi2, maka2);

        //defuzzification
        System.out.println();
        System.out.println("Defuzzification");
        for(int i =0;i<3;i++){
            System.out.println(maka1[i]+" = "+inferensi.output[i]);
        }
        System.out.println();

        float[][] sample = {{10f,20f,30f},{60f,70f,80f},{90f,95f,100f}};
        Defuzzification defuzifikasi =  new Defuzzification(inferensi.output, sample);

        System.out.println("Result : ");
        System.out.println(defuzifikasi.output);



    }
}