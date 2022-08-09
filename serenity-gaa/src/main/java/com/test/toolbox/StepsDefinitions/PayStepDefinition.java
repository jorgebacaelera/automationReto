package com.test.toolbox.StepsDefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import com.test.toolbox.Steps.PaySteps;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class PayStepDefinition {
public static String emailAdress="";
public static String name="";
public static String last_name="";

    @Steps
    PaySteps paySteps;


    @Dado("que el cliente accede a la web de AutomationPractice")
    public void loginAP(){
        paySteps.openWeb();

    }

    @Y("el cliente decide registrarse como usuario indicando su email (.*)")
    public void registryEmail(String email){
        emailAdress=email;
        paySteps.registryUser(email);
    }

    @Y("el cliente ingresa los datos de su nombre (.*) y apellido (.*)")
    public void insertNames(String nombre,String apellido ){
        name=nombre;
        last_name=apellido;
        paySteps.setNames(nombre,apellido);
    }

    @Y("el cliente indica la contraseña (.*) para la cuenta")
    public void insertPassword(String password){
        paySteps.setPassword(password);
    }

    @Y("el cliente confirma los datos de dirección de entrega")
    public void insertDelivery(){
        paySteps.setDataDelivery();
    }

    @Y("el cliente accede de forma automática a la web de compras")
    public void verifyAccount(){
        paySteps.verifyUser();
    }

    @Cuando("el cliente decide seleccionar productos a comprar")
    public void selectProducts(){
        paySteps.selectCategory();
        paySteps.selectProductOne();
        paySteps.selectProductSecond();

    }

    @Y("el cliente confirma la totalidad de productos a comprar")
    public void confirmBuy(){
        paySteps.confirmBuy();
    }

    @Entonces("deberá visualizar el detalle del pedido")
    public void verifySuscriptionCancelled(){
        paySteps.verifyDetails();

    }

}
