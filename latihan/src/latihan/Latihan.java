/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;

/**
 *
 * @author Zero-Inside
 */
public class Latihan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Jurusan j = new Jurusan("IF" , "Informatika");
        Mahasiswa m;
   
        
        Mahasiswa m1 = new Mahasiswa();
        m1.setNim("1301154428");
        m1.setNama("Satrya Budi Pratama");
    
        
        Mahasiswa m2 = new Mahasiswa();
        m2.setNim("1301154421");
        m2.setNama("Satrya");
        
        j.addMahasiswa(m1);
        j.addMahasiswa(m2);
        
        System.out.println("Kode Jurusan " + j.getKode());
        System.out.println("Nama Jurusan " + j.getNama());
        
        System.out.println("List Mahasiswa Terdaftar");
        Mahasiswa[] daftarMahasiswa = j.getDaftarMhs();
        
//        for(int i = 0; i< daftarMahasiswa.length; i++){
//            System.out.println(" - "+ daftarMahasiswa[i].getNama()+ " " + daftarMahasiswa[i].getNim());
//        }
        
        for (Mahasiswa pecah:daftarMahasiswa){
            if (pecah!=null) 
            System.out.println(" -" + pecah.getNim() + pecah.getNama() );
        }
        
        
    }
    
}
