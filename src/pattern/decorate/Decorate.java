package pattern.decorate;

class Work{
//	String can;
//	public Work(String can){
//		this.can=can;
//	}
	public void Do(){
		
	};
}
class Paint extends Work{
    Work work;
	
    public Paint(Work work) {
//		super(work.can);
    	this.work = work;
	}

	@Override
	public void Do() {
		work.Do();
		System.out.println("我能画画");
//		this.work.can=work.can+"我能画画";// TODO Auto-generated method stub
		
	}
	
}
class Mood extends Work{
	Work work;
	
	public Mood(Work work) {
//		super(work.can);
		this.work = work;
	}

	@Override
	public void Do() {
		work.Do();
		System.out.println("我会做木工");
//		this.work.can=work.can+"我会做木工";// TODO Auto-generated method stub
		
	}
	
}
class Paste extends Work{
	Work work;
	
	public Paste(Work work) {
//		super(work.can);
		this.work = work;
	}

	@Override
	public void Do() {
		work.Do();
		System.out.println("我能贴画");
//		this.work.can=work.can+"我能贴画";
		
	}
	
}
public class Decorate {
	public static void main(String[] args) {
		Paste father=new Paste(new Mood(new Paint(new Work())));
		father.Do();
//		System.out.println(father.can);
	}
}

