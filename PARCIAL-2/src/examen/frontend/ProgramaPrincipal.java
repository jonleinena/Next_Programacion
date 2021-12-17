package examen.frontend;

import examen.backend.datos.Empleado;
import examen.backend.datos.EmpleadoEventual;
import examen.backend.datos.EmpleadoPlantilla;
import examen.backend.datos.Paciente;
import examen.backend.datos.Persona;
import examen.interfaces.ISalario;

public class ProgramaPrincipal 
{
	public static void main(String[] args) 
	{
		Persona[] aPersonas = new Persona[5];
		
		EmpleadoPlantilla emp = new EmpleadoPlantilla();
		emp.setNombre("Juan");
		emp.setApellido("Jimenez");
		emp.setSalarioMensual(20);
		aPersonas[0]=emp;
		
		EmpleadoEventual empEven= new EmpleadoEventual();
		empEven.setNombre("Jose");
		empEven.setApellido("Gavi");
		empEven.setPagoHora(35);
		aPersonas[1]=empEven;
		
		Paciente paci= new Paciente();
		paci.setNombre("Julio");
		paci.setApellido("Cortazar");
		String[] medicamentos = {"ibuprofeno","paracetamol", "antihistaminico"};
		paci.setMedicamentos(medicamentos);
		aPersonas[2]=paci;
		
		costeSalarios(aPersonas);
		listarMedicamentos(aPersonas);
		//registrarPersona(aPersonas);
	}
/*
	private static void registrarPersona(Persona[] aPersonas) { //entiendo que solo registro empleados
		// TODO Auto-generated method stub
		
		Empleado empleado = null;
		if(tengoSitio(aPersonas)) {
			System.out.println("Introduzca el tipo de empleado a regisrar I/E (indefinido/eventual)");
			char tipo = UtilidadesLP.leerCaracter();
			if(letraBien(tipo)) {
				switch (tipo) {
				case 'I':
					 empleado = new EmpleadoPlantilla();
					break;
				case 'E':
					 empleado = new EmpleadoEventual();
					break;
				default:
					break;
				}empleado.registrar();
				for (int ç = 0; ç < aPersonas.length; ç++) {
					if(aPersonas[ç] == null) {
						aPersonas[ç] = empleado;
					}
				}
			}else System.out.println("Lo sentimos. introduzca el identicador correcto.");
		}else System.out.println("Lo sentimos, no se pueden registrar mas personas.");
		
	}
	
	private static boolean letraBien(char a) {
		if(a == 'I' || a == 'E') {
			return true;
		} else return false;
	}
	
	private static boolean tengoSitio(Persona[] aPersonas) {
		boolean hayHueco = false;
		for (int i = 0; i < aPersonas.length; i++) {
			if(aPersonas[i]==null) {
				hayHueco= true;
				break;
			}
		}return hayHueco;
	}
*/
	private static void listarMedicamentos(Persona[] aPersonas) {
		for (int i = 0; i < aPersonas.length; i++) {
			if(aPersonas[i] instanceof Paciente) {
				for (int j = 0; j < ((Paciente)aPersonas[i]).getMedicamentos().length; j++) {
					System.out.println(((Paciente)aPersonas[i]).getMedicamentos()[j]);
				}
			}
		}
		
	}

	private static void costeSalarios(Persona[] aPersonas) {
		float costeTotal = 0;
		// TODO Auto-generated method stub
		for (int i = 0; i < aPersonas.length; i++) {
			if(aPersonas[i] instanceof ISalario) {
				costeTotal += ((ISalario)aPersonas[i]).getSalario();
			}
		}
		System.out.println("El coste total de los salarios del hospital es: "+costeTotal);
	}
	
	
}
