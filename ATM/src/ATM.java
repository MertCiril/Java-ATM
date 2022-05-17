import java.util.Scanner;
public class ATM {

	public static void main(String[] args) {
		String[] isim={"Mert","Ahmet","Faruk","Ay�e"};
		int[] no ={1234,5678,9101,1213};
		int[] sifre={1111,2222,3333,4444};
		int[] para={150,100,90,285};
		Scanner scan = new Scanner(System.in);
		int hesapno,hesapsifre,hesap=0,hak=0,secenek=0;
		System.out.print("Hesap No: ");
		hesapno=scan.nextInt();
		System.out.print("�ifre: ");
		hesapsifre=scan.nextInt();
		for(hak=0;hak<2;hak++)
		{
			
			for(int i=0;i<sifre.length;i++)
			{
				if(hesapno==no[i]&&hesapsifre==sifre[i])
				{
					hesap=i;
					
					hak=4;
					break;
				}					
			}	
			if(hak==4)break;
			System.out.println("Yanl�� girdiniz.Bir daha deneyin.");
			System.out.print("Hesap No: ");
			hesapno=scan.nextInt();
			System.out.print("�ifre: ");
			hesapsifre=scan.nextInt();
		}
		if(hak==2)
		{
			System.out.println("Hakk�n�z bitti!");
			
		}
		else
		{
			while(secenek!=9)
			{
				ekrantemizleme();
			System.out.println("Ho� geldin "+isim[hesap]+";");
			System.out.println("\n1-Hesap Detaylar�\n2-Para Yat�rma\n3-Para �ekme"
					+ "\n4-Para G�nderme\n9-��k��\n");
			System.out.print("L�tfen yapmak istedi�in i�lemi se�: ");
			secenek=scan.nextInt();
			if(secenek==1)
			hesapdetaylari(isim,no,para,hesap);
			if(secenek==2)
				parayatirma(para,hesap);
			if(secenek==3)
				paracekme(para,hesap);
			if(secenek==4)
				paragonderme(para,hesap,isim,no);
			if(secenek!=1&&secenek!=2&&secenek!=3&&secenek!=4&&secenek!=9)
			{System.out.println("L�tfen ge�erli bir i�lem girin!");
			 try{ 
			       Thread.sleep(4000); 
			       }catch(InterruptedException e){} 
			}
			}
			if(secenek==9)
				System.out.println("�yi g�nler dileriz.");
			}
		}
	
	public static void ekrantemizleme()
	{
		for(int i=0;i<50;i++)
			System.out.println("\n");
	}
	public static void hesapdetaylari(String []isim,int[]no,int[]para,int hesap)
	{
		ekrantemizleme();
		System.out.println("Hesap Sahibi:"+isim[hesap]
				+"\nHesap Numaras�:"+no[hesap]+
				"\nBakiye:"+para[hesap]+"TL");
		  try{ 
		       Thread.sleep(4000); 
		       }catch(InterruptedException e){} 
	}
	public static int parayatirma (int[]para,int hesap)
	{
		ekrantemizleme();
		Scanner scan = new Scanner(System.in);
		int miktar=0;
		System.out.print("Ne kadar para yatirmak istedi�inizi giriniz:");
		miktar=scan.nextInt();
		if(miktar<0)
			System.out.println("Ge�ersiz de�er!");
		else{
		para[hesap]+=miktar;
		System.out.println("Yeni bakiyeniz: "+para[hesap]);
		}
		 try{ 
		       Thread.sleep(4000); 
		       }catch(InterruptedException e){} 
		return para[hesap];
	}
	public static int paracekme (int[]para,int hesap)
	{
		ekrantemizleme();
		Scanner scan = new Scanner(System.in);
		int miktar=0;
		System.out.print("Ne kadar para �ekmek istedi�inizi giriniz:");
		miktar=scan.nextInt();
		if(miktar>para[hesap]||miktar<0)
			System.out.println("Yetersiz bakiye ya da ge�ersiz de�er!");
		else
		{
			para[hesap]-=miktar;
			System.out.println("Yeni bakiyeniz: "+para[hesap]);
		}
		 try{ 
		       Thread.sleep(4000); 
		       }catch(InterruptedException e){} 
		return para[hesap];
	}
	public static int paragonderme (int[]para,int hesap,String []isim,int no[])
	{
		ekrantemizleme();
		int soru,hesap2,miktar, h2=-1;
		Scanner scan = new Scanner(System.in);
		System.out.print("Para g�ndermek istedi�iniz hesab�n numaras�n� giriniz: ");
		hesap2=scan.nextInt();
		for(int i=0;i<no.length;i++)
		{
			if(hesap2==no[i])
			{
				h2=i;
				break;
			}
		}
		if(h2==-1)
			System.out.println("Girdi�iniz hesap numaras� kullan�lm�yor.");
		else if(h2==hesap)
			System.out.println("Kendinize para g�nderemezsiniz!");
		else
		{
			System.out.print("Girdi�iniz hesap numaras� "+isim[h2]+" ki�isine aittir."
					+ "Onayl�yor musunuz?\nEvet i�in '1' , Hay�r i�in '2' :");
			soru=scan.nextInt();
			if(soru==1)
			{
				System.out.print("G�ndermek istedi�iniz miktar� giriniz: ");
				miktar=scan.nextInt();
				if(miktar>para[hesap]||miktar<0)
					System.err.println("Yetersiz bakiye ya da ge�ersiz de�er!");
				else
				{
					para[hesap]-=miktar;
					para[h2]+=miktar;
					System.out.println(isim[h2]+" ki�isine "+miktar+" TL g�nderdiniz.\n"
							+isim[h2]+" ki�isinin yeni bakiyesi: "+para[h2]
									+ "\n"+isim[hesap]+" ki�isinin yeni bakiyesi: "+para[hesap]);
				}
			}
		}
		 try{ 
		       Thread.sleep(6000); 
		       }catch(InterruptedException e){} 
		return para[hesap];
	}

}

