package pe.edu.upeu.jdmc;
import pe.edu.upeu.jdmc.examen.*;
import pe.edu.upeu.jdmc.utils.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
      	IProblema obj;
	boolean estado=false;
        ResolucionExamen p=new ResolucionExamen();
	try{
		obj=p.factory(args[0]);
		obj.resolver();
		estado=true;
	}catch(Exception e){}
	
    	try{
		if(estado==false){
		  	while(true){
			System.out.println("\n");
		  	obj=p.factory(Teclado.getInstance().leer(" ","Que ejercicio quieres probar 1-4: "));
			obj.resolver();}
		}
	}catch(Exception e){}
    }
}
