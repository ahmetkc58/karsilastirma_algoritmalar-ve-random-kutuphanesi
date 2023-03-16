/*
1000 ELEMANLI 4 DİZİ
ALGORİTMALARIYLA SIRALA VE PERFORMANSINI ÖLÇ
long start = System.currentTimeMillis();
// kodu yaz
long elapsedTimeMillis = System.currentTimeMillis()-start;

 */
package algoritma_mantığı_09_03;

import java.util.Random;

public class RASTGELE {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] d1 = r();//d1 dizisi ni randomladık  bubble olsun bu 
        d1 = bubble(d1);
        yazdırma(d1);
        System.out.println("bubble bitti");
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        System.out.println(elapsedTimeMillis + "   milisaniye sürdü");
        long start1 = System.currentTimeMillis();

        int[] d2 = r();//d2 yi randomladık selection selection olsun bu
        d2 = selection(d2);
        yazdırma(d2);

        System.out.println("selection bitti");
        long times2 = System.currentTimeMillis() - start1;

        System.out.println(times2 + "   milisaniye sürdü");
        long start2 = System.currentTimeMillis();

        int[] d3 = r();//d3 randomladık  comb sort olsun bu 
        d3 = comb(d3);
        yazdırma(d3);
        System.out.println("comb bitti");
        long times3 = System.currentTimeMillis() - start2;

        System.out.println(times3 + "   milisaniye sürdü");
        long start3 = System.currentTimeMillis();

        int[] d4 = r();//d4 dizisini radomladık buda ınsectron olsun 
        d4 = ınsectron(d4);
        yazdırma(d4);
        System.out.println("ınsectron  bitti");
        long times4 = System.currentTimeMillis() - start3;
        System.out.println(times4 + "   milisaniye sürdü");

    }

    public static int[] r() {//bu metotu yazmamızın nedeni kulanıcının bizden istediiği üzere 1000 elemanlı 4 tane dizi oluşturmak için  
        Random random = new Random();//random metotunu kulanmak için new ledik 
        int[] a1 = new int[1000];//1000 elemanlı bir dizi oluşturduk 
        for (int i = 0; i < 1000; i++) {
            a1[i] = random.nextInt(10000);//0 ile 10000 arasındaki değerleri randomlamasını istedim 
        }
        return a1;
    }

    public static void yazdırma(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] bubble(int a[]) {//bubble sort kulanmamız için yazdığımız bir metot 
        for (int i = 0; i < a.length; i++) {//eleman sayısı kadar tekrar etmesi gerekmektedir
            for (int j = 0; j < a.length - 1; j++) {//son elemandan sonra bir eleman olmayacağı için -1 koyduk 
                if (a[j] > a[j + 1]) {
                    int x = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = x;
                }
            }
        }
        return a;
    }

    public static int[] selection(int[] a) {//selection sort unu kulanmamız için metotu yazdık 
        for (int i = 0; i < a.length; i++) {//elimizde tutacağımız elemanı gezdirmek için kulandık
            for (int j = 0; j < a.length; j++) {// elimizde elemanı tutarken diyer elemanları gezmek için kulandık 
                if (a[i] < a[j]) {
                    int x = a[j];
                    a[j] = a[i];
                    a[i] = x;
                }
            }
        }
        return a;
    }

    public static int[] comb(int a[]) { //comb sort unu kulanmak için bu metottan yardım aldık 
        for (int i = (a.length / 2); i > 0; i--) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + i]) {
                    int x = a[j];
                    a[j] = a[j + i];
                    a[j + i] = x;
                }
            }
        }

        return a;
    }

    public static int[] ınsectron(int[] a) {//ınsectron sort unu kulanmak için yazdık 
        for (int i = 1; i < a.length; i++) {// burada  kıyaslayacağımız elemanın konumu buk-lmak için yazdık 
            int e = i;// burada e yi kulanmamızın sebebi eğer elimizde tuttuğumuz eleman yerdeğiştirirse i yi değiştirmek yerine e yi değiştirmek for döngüsünü  bozmamış olur
            int j = i;//i den başlayık geriye doğru gider 
            while (j >= 0) {
                if (a[e] < a[j]) {
                    int x = a[e];
                    a[e] = a[j];
                    a[j] = x;
                    e--;
                }
                j--;
            }
        }
        return a;
    }
}
