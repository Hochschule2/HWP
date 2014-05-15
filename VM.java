package vm;

public class Machine {
	int PC=0;
	int memory[] = new int[1024];
	int reg[] = new int[32];
	public void run(){
		int idx0 = 6;
		int idx1 = 3;
		int cmd = 12;
		int v = 1;
		
		memory[PC]= (v << 15) + (idx0<<10) + (idx1<<5) + (cmd<<0); // add R6,R3

		idx0 = (memory[PC] >> 10) & 31;
		idx1 = (memory[PC] >> 5) & 31 ;
		cmd =( memory[PC]) & 31;
		 
		 System.out.println(memory[0]);
		 System.out.println("CMD: "+cmd);
		 System.out.println("0: "+ idx0);
		 System.out.println("1: "+ idx1);
		 
		switch(cmd){
		default: System.out.println("default");break;
		case 1: System.out.println("ADD " + (reg[idx0]+=reg[idx1]));PC++;break;
		case 2: System.out.println("SUB " + (reg[idx0]-=reg[idx1]));PC++;break;
		case 3: System.out.println("MOVE");PC++;break;
		case 4: System.out.println("JMP");PC++;break;
		case 5: System.out.println("MOVE_FROM_MEM_TO_REG");PC++;break;
		case 6: System.out.println("MOVE_FROM_REG_TO_MEM");PC++;break;
		case 7: System.out.println("MOVE_FROM_REG_TO_REG");PC++;break;
		case 8: System.out.println("MOVE_FROM_MEM_TO_MEM");PC++;break;
		case 9: System.out.println("MUL " + (idx0 *= idx1));PC++;break;
		case 10: System.out.println("AND ");PC++;break;
		case 11: System.out.println("OR");PC++;break;
		case 12: System.out.println("DIV " + (idx0/=idx1));PC++;break;
		case 13: System.out.println("HIG");PC++;break;
		case 14: System.out.println("EQU");PC++;break;
		case 15: System.out.println("NOT");PC++;break;
		case 16: System.out.println("JIT");PC++;break;
		case 17: System.out.println("RET");PC++;break;
		case 18: System.out.println("JSR");PC++;break;
		}
	}
	public static void main(String[] args) {
		Machine machine = new Machine();
		machine.run();
	}
}
