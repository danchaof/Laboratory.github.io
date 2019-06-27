package ay.laboratory.service;

public class LaboratoryException extends Exception
{
  public LaboratoryException(){
  }

  public LaboratoryException(String message, Throwable cause) {
    super(message, cause);
  }

  public LaboratoryException(String message){
    super(message);
  }

  public LaboratoryException(Throwable cause){
    super(cause);
  }
}