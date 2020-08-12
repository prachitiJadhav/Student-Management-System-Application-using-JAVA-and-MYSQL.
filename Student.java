class Student{

private int rno;
private String name;
private int s1;
private int s2;
private int s3;



Student(){ }

public Student(int rno,String name,int s1,int s2,int s3){
this.rno=rno;
this.name=name;
this.s1=s1;
this.s2=s2;
this.s3=s3;


}



public void setRno(int rno){
this.rno=rno;
}
public int  getRno(){
return rno;
}
public void setName(String name){
this.name=name;
}

public String getName(){
return name;}

public void setS1(int s1){
this.s1=s1;
}
public int  getS1(){
return s1;
}

public void setS2(int s2){
this.s2=s2;
}
public int  getS2(){
return s2;
}

public void setS3(int s3){
this.s3=s3;
}
public int  getS3(){
return s3;
}


}