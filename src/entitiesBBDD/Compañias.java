package entitiesBBDD;

public class Compañias {
    
    private String coberturas;
    private String formaPago;
    private String Ncom; //FK
    private String telcom;
    
   
    public Compañias(String coberturas, String formaPago, String ncom, String telcom) {
		super();
		this.coberturas = coberturas;
		this.formaPago = formaPago;
		Ncom = ncom;
		this.telcom = telcom;
	}

	//Metodos de acceso
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getCoberturas() {
        return coberturas;
    }
    
    public void setCoberturas(String coberturas) {
        this.coberturas = coberturas;
    }
    
    public String getFormaPago() {
        return formaPago;
    }
    
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    
    public String getNcom() {
        return Ncom;
    }
    
    public void setNcom(String Ncom) {
        this.Ncom = Ncom;
    }
    
    public String getTelcom() {
        return telcom;
    }
    
    public void setTelcom(String telcom) {
        this.telcom = telcom;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
