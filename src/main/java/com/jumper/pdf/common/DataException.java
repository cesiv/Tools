package com.jumper.pdf.common;


public class DataException extends RuntimeException
{
    private static final long serialVersionUID = -4983182908260262069L;
    
    public DataException()
    {
        super();
    }
    
    public DataException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public DataException(String message)
    {
        super(message);
    }
    
    public DataException(Throwable cause)
    {
        super(cause);
    }
}
