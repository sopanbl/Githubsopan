import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.lang.*;
import java.time.*;
import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Jawaban {
    public void jawaban2(){
        
        String[] namaBuku = {"A", "B", "C", "D"};
        int[] durasiPeminjaman = {14, 3, 7, 7};
        int jumlahDenda;

      Scanner input1 = new Scanner(System.in);
      System.out.println("Masukan tanggal mulai (dd/MM/yyyy) :");
      String waktuPertama = input1.nextLine();

      Scanner input2 = new Scanner(System.in);
      System.out.println("Masukan tanggal berakhir (dd/MM/yyyy) :");
      String waktuKedua = input2.nextLine(); 
      
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        for(int i = 0; i < 4 ; i++){
            try {
             LocalDate date1     = LocalDate.parse(waktuPertama,dtf);
             LocalDate date2     = LocalDate.parse(waktuKedua,dtf);
              int daysBetween = (int) ChronoUnit.DAYS.between(date1, date2);

              int selisihHari = daysBetween - durasiPeminjaman[i];
              // System.out.println ("Days: " + daysBetween);


              //menghitung denda
              if(selisihHari <= 0){
                jumlahDenda = 0;
                selisihHari = 0;
              }else{
                jumlahDenda = selisihHari * 100;
              }
            System.out.println("Buku " + namaBuku[i] + ":");
                System.out.println("Tanggal Pengembalian: " + date2);
                System.out.println("Keterlambatan: " + selisihHari + "hari");
                System.out.println("Jumlah Denda: " + jumlahDenda);
                System.out.println();


            } catch (Exception e) {
                e.printStackTrace();
                 }
        }
    
    }

    public void jawaban11(){
         Scanner input11 = new Scanner(System.in);
         System.out.println("masukan : ");
            String inputan = input11.nextLine();

        StringBuilder inputan1 = new StringBuilder();

        inputan1.append(inputan);
        inputan1.reverse();

        inputan = inputan1.toString();
        System.out.println(inputan);
    
    for(int i = 0 ; i < inputan.length() ; i++){
        if(inputan.length() % 2 == 0){
        System.out.println("***" + inputan.charAt(i) +"***");
        }else{
            System.out.println("**" + inputan.charAt(i) +"**");
        }
        

    }
    
    }

    public void jawaban12(){
       Scanner input11 = new Scanner(System.in);
         System.out.println("masukan : ");
            String inputan = input11.nextLine(); 
            String[] arayInput = inputan.split(" ");
            int [] arr = new int [arayInput.length];

            for(int i = 0 ; i < arayInput.length; i++){
                arr[i] = Integer.parseInt(arayInput[i]);
            }  

        for(int i = 0 ; i < arayInput.length -1  ; i++){
           if (arr[i] > arr[i + 1 ]  ){
            int tampung = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tampung;
            i = -1;
           }
        }   
        
    

    for(int i = 0 ; i < arr.length; i++){
        System.out.println(arr[i]);
    }
    }

    public void jawaban9(){

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Input tidak valid. Masukkan angka.");
            scanner.next(); // Membersihkan buffer
        }
        int angka = scanner.nextInt();
        int[] deretanAngka = new int[angka];
        //deretanAngka[0] = angka;

        for(int i = 0 ;i < angka ; i ++){
            deretanAngka[i] = angka*(i+1);
        }

        for(int j = 0 ; j < angka; j++){
            System.out.print(deretanAngka[j] + " ");
        }
    }

    public void jawaban6(){  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Silahkan input: ");
        String inputan = scanner.nextLine();
        String reverse = "";
        int length = inputan.length();

        for(int i = length - 1 ;i >= 0; i-- ){
            reverse = reverse + inputan.charAt(i);
        }

        
        if(inputan.equalsIgnoreCase(reverse)){
            System.out.println("'"+inputan+"'"+" "+ "ini adalah palindrome");
        } else{
            System.out.println("'"+inputan+"'"+" "+ "ini bukan palindrome");
        }

    }

    public void jawaban14(){
        int[] deret = {3,9,0,7,1,2,4};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Input tidak valid. Masukkan angka.");
            scanner.next(); // Membersihkan buffer
        }
        int inputan = scanner.nextInt();

        for(int i = 0 ; i < inputan; i ++){
            int tampungIndexPertama = deret[0];
            for(int j = 0 ; j < deret.length - 1 ; j ++){
                deret[j] = deret[j+1]; 
        }
        deret[deret.length - 1 ] = tampungIndexPertama;
        }
        System.out.print("Isi array: ");
        for (int i = 0; i < deret.length; i++) {
            System.out.print(deret[i] + " ");
        }


    }

    public void jawaban3(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukan tanggal masuk (dd/MM/yyyy HH:mm:ss):");
        String tanggalMasuk = scanner.nextLine();

         System.out.println("Masukan tanggal keluar (dd/MM/yyyy HH:mm:ss):");
        String tanggalkeluar = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        LocalDateTime waktuPertama = LocalDateTime.parse(tanggalMasuk, dtf);

        LocalDateTime waktuKedua = LocalDateTime.parse(tanggalkeluar,dtf);

        // Menghitung selisih waktu
        Duration selisih = Duration.between(waktuPertama, waktuKedua);
        Duration waktu8Jam = Duration.ofHours(8);
        Duration waktu24Jam = Duration.ofHours(24);
        int jumlahBayar = 0;


        // Mendapatkan hasil dalam jam, menit, dan detik
        long jamSelisih = selisih.toHours();
        long menitSelisih = selisih.toMinutesPart();
        long detikSelisih = selisih.toSecondsPart();

        if(selisih.toSeconds() <= waktu8Jam.toSeconds()){
            jumlahBayar =(int) jamSelisih * 1000 ;
        } else if (selisih.toSeconds()<= waktu24Jam.toSeconds()) {
            jumlahBayar = 8000;
        } else{
            jumlahBayar = 15000 + ((int) jamSelisih - 24)*1000;
        }
        System.out.println("Jumlah bayar = "+ jumlahBayar);
        System.out.println("Selisih waktu: " + jamSelisih + " jam, " + menitSelisih + " menit, " + detikSelisih + " detik");
    }

    public void jawaban17(){
       //  String[] catatanPerjalanan = {"N","N","T","T","N","N","T","N","T","T","T","N","T","T","T","N","T","N"};
        String[] catatanPerjalanan = {"N","T","T","T"};
        int gunung = 0;
        int lembah = 0;
        int tampung = 0;
       
        for(int i = 0 ; i < catatanPerjalanan.length;i++){
               if (catatanPerjalanan[i].equals("N")){
                    tampung ++;
                   if(tampung == 0) {
                       lembah ++;
                   }
               }else {
                    tampung --;
                   if(tampung == 0){
                       gunung++;
                   }
               }

               }
        System.out.println("Jumlah gunung :" + gunung);
        System.out.println("Jumlah lembah :" + lembah);
    }

    public void jawaban19(){

        boolean[] alfabet = new boolean[26];
     //   String kalimat = "Check back tomorrow; I will see if the book has arrived";
        String[] beberapaKalimat = {"Sphinx of black quartz, judge my vow",
        "Brawny gods just flocked up to quiz and vex him","Check back tomorrow; I will see if the book has arrived"};
        int index = 0;
        boolean pangram = true;

        for(int i = 0; i < beberapaKalimat.length;i++){
            if(beberapaKalimat[i].length()>26){
                for(int j = 0 ; j < beberapaKalimat[i].length();j++){
                    char huruf = beberapaKalimat[i].charAt(j);
                    if(huruf >= 'A'&& huruf <= 'Z'){
                        index = huruf - 'A';
                    }else if(huruf >= 'a'&& huruf <= 'z'){
                        index = huruf - 'a';
                    }
                    alfabet[index] = true;
                }
            }else{
                pangram = false;
            }
            for(int k = 0 ; k < alfabet.length;k++){
                if(alfabet[k]==false){
                    pangram = false;
                    break;
                }
            }
            if(pangram){
                System.out.println(beberapaKalimat[i]);
                System.out.println("Ini adalah kalimat pangram!");
                System.out.println();
            }else{
                System.out.println(beberapaKalimat[i]);
                System.out.println("Ini bukan kalimat pangram!");
                System.out.println();
            }
            alfabet = new boolean[26];
        }

    }
    public void jawaban20(){
        String a ="GGG";
        String b ="KBK";
        int jarak = 4;
        int moveA = 0;
        int moveB = 0;
        for(int i = 0; i < 3;i++){
            if(a.charAt(i) == 'G'&& b.charAt(i) == 'K'||
            a.charAt(i) == 'B'&& b.charAt(i) == 'G'|| a.charAt(i) == 'K'&& b.charAt(i) == 'B'){
                jarak -= 1;
                moveA += 2;
                moveB -=1;
            }else if(b.charAt(i) == 'G'&& a.charAt(i) == 'K'||
            b.charAt(i) == 'B'&& a.charAt(i) == 'G'|| b.charAt(i) == 'K'&& a.charAt(i) == 'B'){
                jarak -= 1;
                moveB += 2;
                moveA -= 1;
            }
            if(jarak == 0){
                break;
            }
        }
        if(jarak == 0 && moveA > moveB){
            System.out.println("A pemenangnya!");
        }else if(jarak == 0 && moveB > moveA){
            System.out.println("B pemenangnya!");
        }else{
            System.out.println("Tidak ada pemenang");
        }
    }
    public void jawaban18(){
        int[] jamMakanKue = {9,13,15,17};
        int[] kaloriKue   = {30,20,50,80};
        int waktuTotalBerolahraga = 0;
        int jamMulaiOlahraga = 18;
        int selisihWaktu = 0;
       

        for(int i = 0; i < jamMakanKue.length;i++){
            selisihWaktu = jamMulaiOlahraga - jamMakanKue[i];
            double menitOlahraga = 0.1 * kaloriKue[i] * selisihWaktu;
            waktuTotalBerolahraga += menitOlahraga;
        }
        System.out.println(waktuTotalBerolahraga);

        int totalMinum = waktuTotalBerolahraga / 30;
        int totalCCAir = totalMinum * 100 ; 
        int totalMinumAir = totalCCAir + 500 ;
        
        System.out.println(totalMinumAir +" "+"CC Air Minum");

    }
    public void jawaban13(){
        double sudutJarumPendek = 0;
        double sutJarumPanjang = 0;
        double totalSudut = 0;
        double[] jam ={9,05};
        double menit = 0;
        
        if (jam[0] > 12) {
            jam[0] = jam[0] - 12;
        }

        sudutJarumPendek = (jam[0]) * 30;
        menit = (jam[1]) * 30 / 60 ;
        sudutJarumPendek =sudutJarumPendek + menit;
        sutJarumPanjang = (jam[1]) * 6;

        totalSudut = Math.abs(sutJarumPanjang - sudutJarumPendek);
        if(totalSudut > 180 && totalSudut <= 360){
            totalSudut =Math.abs(360 - totalSudut);
        }
        
        System.out.println(totalSudut);
    }

    public void jawaban15(){
        String waktuString = "01:40:44 PM";

            DateTimeFormatter formatter12Jam = DateTimeFormatter.ofPattern("hh:mm:ss a");
            DateTimeFormatter formatter24Jam = DateTimeFormatter.ofPattern("HH:mm:ss");

            LocalTime localDateTime = LocalTime.parse(waktuString, formatter12Jam);

            String waktu24Jam = formatter24Jam.format(localDateTime);

            System.out.println("Waktu 12 Jam: " + waktuString);
            System.out.println("Waktu 24 Jam: " + waktu24Jam);
           
            if (waktuString.contains("PM")) {
               int jam =  Integer.parseInt(waktuString.substring(0,2));
               jam += 12;
               waktuString = waktuString.replace(waktuString.substring(0,2),Integer.toString(jam));
              waktuString =  waktuString.replace(" PM", "");
               System.out.println(waktuString);
            }
       
    }

    public void jawaban4(){
        int prima = 2;
        boolean isPrima = true;
        int panjang = 1;
        int panjangPrima = 5;
        double gggg = Math.sqrt(prima);

        while (panjang <= panjangPrima ) {
            for(int i = 2; i <= Math.sqrt(prima);i++){
                if (prima % i == 0) {
                    isPrima = false;
                    break;
                }
            }
            if (isPrima == true) {
                panjang++;
                System.out.println(prima);
            }
            prima++;
            isPrima = true;   
        }
       
    }

    public void jawaban22(){
        int[] lilinMeleleh = {1,1,2,3,5,8,13};
        int[] panjangLilin = {3,3,9,6,7,8,23};  
        int[] sisaLilin = new int[7];
        int stop = 1;
        for(int i = 1; i <= panjangLilin.length;i++){
            for(int j = 0; j<panjangLilin.length;j++){
                sisaLilin[j] = panjangLilin[j]-lilinMeleleh[j];
            }
           for(int k = 0; k < sisaLilin.length;k++){
            if(sisaLilin[k]== 0 ){
                stop = 0;
                break;
            }
           }
           if (stop == 0) {
            break;
           }
        }
        for(int i=0;i<sisaLilin.length;i++){
            if(sisaLilin[i] == 0){
                System.out.println("Lilin yg pertama kali habis Lilin ke- "+ i);
            }
        }
    }
    public void jawaban7(){
        int[] deretAngka = {3,1,2,3,1,3,3};
        
        double mean = 0;
        
        //mean
        for(int i = 0;i < deretAngka.length;i++){
            mean = mean + deretAngka[i];
        }
        mean = mean / deretAngka.length;
        System.out.println("mean = "+ mean);

        if(deretAngka.length % 2 != 0){
            System.out.println("Median = "+deretAngka[deretAngka.length / 2]);
        }else{
             System.out.println("Median = "+ (deretAngka[deretAngka.length / 2 - 1]+deretAngka[deretAngka.length / 2])/2);
        }

        //Modus
        int[] valueAngka = new int[10];
        
        for(int i = 0; i < deretAngka.length;i++){
            int index = deretAngka[i];
           valueAngka[index] ++;
        }
        
        int[] sortValueAngka = Arrays.copyOf(valueAngka, 10);
        Arrays.sort(sortValueAngka);
        int nilaiMax = sortValueAngka[9];
        List<Integer> listModus = new ArrayList<>();
        for(int i = 0; i < valueAngka.length;i++){
            if (valueAngka[i] == nilaiMax) {
                listModus.add(i);
            }
        }
        Collections.sort(listModus); 
        System.out.println("Nilai modusnya adalah "+ listModus.get(0));
    }

    public void jawaban10(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] inputPerKata = input.split(" ");

        for(int i = 0 ; i < inputPerKata.length;i++){
           
            String kata = inputPerKata[i];
            int panjangKata = inputPerKata[i].length();
            String kataAwal = kata.substring(0,1);
            String KataAkhir = kata.substring( panjangKata - 1 );
            String gabungan = kataAwal + "***" + KataAkhir;
            System.out.print(gabungan+" ");
        }
    }
    public void jawaban5(){
        int panjang = 10;
        int awal = 0;
        int akhir = 1;
        int temp = 0;
       
        for(int i = 1; i <= panjang;i++){
            System.out.println(awal);
            temp = akhir + awal;
            awal = akhir;
            akhir = temp;
            
        }
    }
    public void jawaban21(){
        int[] panjangJalan =new int[10];
        panjangJalan[2] = 1;
        panjangJalan[5] = 1;
        int D = -1;
        int ST = 0;
         //Lubang ada di panjang jalan ke-3
        while (D < panjangJalan.length) {
            if(ST < 2){
                D++;
                ST++;
                if (panjangJalan[D] == 1) {
                    System.out.println("Failed");
                    break;
                }
                System.out.println("W");
            }else if(ST >=2){
                int tempD = D;
                int tempST = ST;  
                D += 3;
                ST -=2;
                if (D <= panjangJalan.length - 1) {
                    if ((panjangJalan[D] == 1 && D < panjangJalan.length && panjangJalan[tempD+1] != 1 && ST < 1) ||
                    (1 == panjangJalan[D+1] && D < panjangJalan.length && panjangJalan[tempD+1] != 1 && ST < 1)) {
                        D = tempD + 1;
                        ST = tempST + 1;
                        System.out.println("W");
                        continue;
                    }
                    if (1 == panjangJalan[D] ||(1 + 1 == panjangJalan[D] && ST == 0 ) ) {
                        System.out.println("Failed");
                        break;
                    }
                }
                System.out.println("J");
            }
            
        }
    }
}   
