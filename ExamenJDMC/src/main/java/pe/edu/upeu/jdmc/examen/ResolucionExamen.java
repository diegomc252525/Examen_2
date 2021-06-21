package pe.edu.upeu.jdmc.examen;
import pe.edu.upeu.jdmc.utils.Teclado;
public class ResolucionExamen{
	public IProblema factory(String clase){
		if(clase.equals("1")){
		  	IProblema p=new Pr1();
			return p;
		}else if(clase.equals("2")){
			IProblema p=new Pr2();
			return p;
		}else if(clase.equals("3")){
			IProblema p=new Pr3();
			return p;
		}else if(clase.equals("4")){
			IProblema p=new Pr4();
			return p;
		}
		else{
		return null;}
	}	  
}
//problema 1 sacar impuestos
class Pr1 implements IProblema{
	public void resolver(){
		float[] suma={0,0,0};
		double impuesto=0.0;
		Teclado tc=Teclado.getInstance();
		int numeroVeces=tc.leer(1,"Cuantos autos de Categoria 1: ");
		for(int i=0;i<numeroVeces;i++){
			impuesto=tc.leer(1.1,"valor del auto numero "+(i+1)+": ")*0.12;
			suma[0]+=impuesto;
		}
		numeroVeces=tc.leer(1,"Cuantos autos de Categoria 2: ");
		for(int i=0;i<numeroVeces;i++){
			impuesto=tc.leer(1.1,"valor del auto numero "+(i+1)+": ")*0.08;
			suma[1]+=impuesto;
		}
		numeroVeces=tc.leer(1,"Cuantos autos de Categoria 3: ");
		for(int i=0;i<numeroVeces;i++){
			impuesto=tc.leer(1.1,("valor del auto numero "+(i+1)+": "))*0.05;
			suma[2]+=impuesto;
		}
		
		for(int i=0;i<3;i++){
			System.out.println("Impuesto para la categoria "+(i+1)+": "+suma[i]);
		}
		System.out.println("Impuesto total es: "+(suma[0]+suma[1]+suma[2]));
	}
}
//ejercicio 2 hacer una tabla de multiplicar
class Pr2 implements IProblema{
	public void resolver(){
	  	System.out.println("Tabla de multiplicar");
		for(int i=1;i<21;i++){
			System.out.println("tabla de multiplicar del "+i);
		  	for(int j=1;j<11;j++){
				System.out.println(i+" * "+j+" = "+(i*j));
			}
		}	
	}
}
//problema 3 probar los numeros perfectos
class Pr3 implements IProblema{
	public void resolver(){
	  	//numeros primos debajo de 100
	  	int[] numPrimos={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	  	long pNum=Teclado.getInstance().leer(1,"ingrese que cantidad de numeros perfectos desea ver, tenga cuidado con colocar numeros altos podria llegar a tener un crash, en los 8 primeros datos: ");
		int c=0,i=0;
		while(c<pNum){
			c+=numPerfecto(numPrimos[i++]);} 
 
			
	}
	public long numPerfecto(long n){
		double h=Math.pow(2,n-1)*(Math.pow(2,n)-1);
		if(pr((long)Math.round(h))==true){
		System.out.println(h);
		return 1;}
		return 0;
	}
	public boolean pr(long numero){
		long w=numero;
		long suma=0;
		
		for(long i=2;i<w;i++){
			if(numero%i==0){
				w=numero/i;
				//System.out.print(i+" "+w+"\n");
				suma+=w+i;
			}
		}
		if(suma+1==numero){
			System.out.print("numero perfecto ");
			return true;
		}else{return false;}
	}
}
//ejercicio cuatro potencia recursiva
class Pr4 implements IProblema{
	public void resolver(){
		int base=Teclado.getInstance().leer(1,"cual es la base: ");
		int exponente=Teclado.getInstance().leer(1,"cual es el exponente: ");
		System.out.println("el resultado es: "+recursivo(base,exponente));
	}
	private int recursivo(int base,int exponente){
		if(exponente>1){
			return base*recursivo(base,exponente-1);
		}else{
			return base;
		}
	}

}
