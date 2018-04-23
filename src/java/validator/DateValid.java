/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author павел
 */
@FacesValidator("CreationDateValid")
public class DateValid implements Validator{
    


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       
        LocalDate  dateofbirth = ((Date)value).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate  datenow = LocalDate.now();
        
        double age = datenow.getYear()-dateofbirth.getYear();
        double nowM =   datenow.getMonthValue();  
        double birthM = dateofbirth.getMonthValue();
        double nowD =   datenow.getDayOfMonth();  
        double birthD = dateofbirth.getDayOfMonth();
        
        if (nowM < birthM)
        {
            age = age - 1;
        }
        else if(nowM==birthM){
            
            if(nowD < birthD)
        {
            age = age - 1;
        }
        }
        if(age < 20)
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ограничение по возрасту","Читатели от 10 до 20 лет"));
        
    }
    
}
