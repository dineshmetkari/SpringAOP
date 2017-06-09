package com.javatpoint;  
  
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;  
  
@Aspect  
public class TrackOperation{  
    @Pointcut("execution(* Operation.*(..))")  
    public void pointcutMethod(){}//pointcut name  
      
    @Before("pointcutMethod()")//applying pointcut on before advice  
    public void myadviceBefore(JoinPoint jp)//it is advice (before advice)  
    {  
        //System.out.println("additional concern");  
        System.out.println("///////////////////////////////\n1.0 TrackOperation: myadviceBefore :  Method Signature: "  + jp.getSignature());  
    }  
    
    @After("pointcutMethod()")//applying pointcut on before advice  
    public void myadviceAfter(JoinPoint jp)//it is advice (before advice)  
    {  
        //System.out.println("additional concern");  
        System.out.println("3.0 TrackOperation: myadviceAfter : Method Signature: "  + jp.getSignature());  
    }  
    
    
    
    @AfterReturning(  
            pointcut = "execution(* Operation.*(..))",  
            returning= "result")  
              
  public void myadviceAfterReturning(JoinPoint jp,Object result)//it is advice (after returning advice)  
  {  
    	
    	System.out.println("\n\n 4.0 TrackOperation: myadviceAfterReturning : Method Signature: "  + jp.getSignature());  
      System.out.println("Result in advice: "+result);  
      System.out.println("end of after returning advice...\n\n///////////////////////////////\n\n\n");  
  }  
    
    
    @Around("pointcutMethod()")  
    public Object myadviceAround(ProceedingJoinPoint pjp) throws Throwable   
    {  
    	
    	System.out.println("\n\n2.1 TrackOperation: myadviceAround Before : Method Signature: "  + pjp.getSignature());  
          
        Object obj=pjp.proceed();  
        System.out.println("\n\n2.2TrackOperation: myadviceAround After : Method Signature: "  + pjp.getSignature());  
        
        return obj;  
    }  
    
}  