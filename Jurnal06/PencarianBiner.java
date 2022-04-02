import java.security.SecureRandom;//menggenerate angka random
import java.util.Arrays;
import java.util.Scanner;

public class PencarianBiner {
    public static int pencarianBinary(int[] data, int key){
        int low = 0; //area terbawah pencarian
        int high = data.length -1; //area teratas pencarian
        int middle = (low + high +1)/2; //median
        int posisi = -1;//mengembalikan nilai jika tidak ditemukan

        do{//Perulangan untuk mencari elemen
            //print elemen yang tersisa
            System.out.println(remainingElements(data, low, high));

            //membuat spasi untuk tiap alinea
            for(int i = 0; i <middle;i++){
                System.out.print(" ");
            }
            System.out.println(" * ");//mengindikasi median sekarang
            //Jika elemen ditemukan di tengah
            if(key == data[middle]){
                posisi = middle;// Posisi ada di tengah
            }
            else if(key < data[middle]){//jika median terlalu besar
                high = middle - 1;//mengeliminasi median yang lebih tinggi
            }
            else{//jika media terlalu rendah
                low = middle +1;//mengeliminasi median yang lebih kecil
            }
            middle = (low + high +1)/2;//menghitung ulang median
        }while((low <= high)&&(posisi == -1));
        return posisi;//mengembalikan nilai posisi pencarian kunci
    }
    //method untuk mengeluarkan nilai tertentu dalam array
    private static String remainingElements(int[]data, int low, int high){
        StringBuilder sementara = new StringBuilder();
        //Spasi tiap alinea
        for(int i = 0; i < low; i++){
            sementara.append(" ");
        }
        //menambah elemen di kiri array
        for(int i = low; i <= high; i++){
            sementara.append(data[i] + " ");
        }
        return String.format("%s%n", sementara);
    }

    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();

        //membuat array dengan 15 integer randome dalam perintah berurutan
        int[]data = generator.ints(15,10,91).sorted().toArray();
        System.out.printf("%s%n%n", Arrays.toString(data));//Menampilkan Array
        //Meminta input dari pengguna
        System.out.print("Mohon masukkan sebuah Integer(-1 untuk keluar): ");
        int searchInt = masuk.nextInt();

        while(searchInt != -1){
            //lakukan pencarian
            int posisi = pencarianBinary(data, searchInt);

            if(posisi == -1){//tidak ditemukan

                System.out.printf("%d was not found%n%n", searchInt);
            }
            else{//ditemukan
                System.out.printf("%d was found in position %d%n%n", searchInt,posisi);
            }
            //Meminta input lagi
            System.out.print("Mohon masukkan sebuah Integer(-1 untuk keluar): ");
            searchInt = masuk.nextInt();
        }
        
    }
}
