package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        listMahasiswa.add(new Mahasiswa("042","Ihdazul Aruna Syahriar","D3IF 45-04"));
        listMahasiswa.add(new Mahasiswa("041","Wulan maulidya","D3IF 45-03"));
        listMahasiswa.add(new Mahasiswa("005","Alfian M. Rizqi","D3IF 45-04"));

        cetakList(listMahasiswa);

        System.out.println("Masukkan NIM mahasiswa yang ingin dicari : ");
        String nomor = masuk.nextLine();

        Mahasiswa mhsResult = cariMahasiswa(listMahasiswa,nomor);

        System.out.print("Mahasiswa dengan NIM "+ nomor);
        System.out.println(" adalah: \n" + mhsResult);
    }
    private static void cetakList(ArrayList<Mahasiswa> arrayList){
        for (Mahasiswa mhs:arrayList){
            System.out.println(mhs);
        }
        System.out.println();
    }
    private static Mahasiswa cariMahasiswa(ArrayList<Mahasiswa> list, String nim){
        Mahasiswa result;
        Collections.sort(list);
        int index = Collections.binarySearch(list,new Mahasiswa(nim,null,null));
        result =list.get(index);

        return result;
    }
}
