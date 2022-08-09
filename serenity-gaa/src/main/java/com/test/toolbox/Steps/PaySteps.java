package com.test.toolbox.Steps;

import com.test.toolbox.StepsDefinitions.PayStepDefinition;
import com.test.toolbox.Util.Util;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import java.util.concurrent.TimeUnit;
import com.test.toolbox.Page.ElementsPage;
import static com.test.toolbox.Page.ElementsPage.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PaySteps extends PageObject {

    ElementsPage elementsPage;
    public static String priceProduct1="";
    public static String priceProduct2="";
    public static String titleProduct1="";
    public static String titleProduct2="";
    public static String fullname="";
    public static String companyName="Auna Clinicas";
    public static String phone="921447908";

    @Step ("Ingresa a la web de prueba")
    public void openWeb() {
        setDefaultBaseUrl("http://automationpractice.com/");
        open();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Serenity.takeScreenshot();

    }


    @Step ("Registra usuario")
    public void registryUser(String email){
        Util.waitFor(5);
        (getDriver().findElement(By.className(buttonLogin))).click();
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        (getDriver().findElement(By.id(inputEmail))).sendKeys(email);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.id(buttonCreate))).click();

    }

    @Step ("Nombre y Apellidos")
    public void setNames(String name,String apellido ){
        Util.waitFor(5);
         getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        (getDriver().findElement(By.id(id_gender1))).click();
        (getDriver().findElement(By.id(id_customer_firstname))).sendKeys(name);
        (getDriver().findElement(By.id(id_customer_lastname))).sendKeys(apellido);
        Serenity.takeScreenshot();
    }

    @Step ("Login")
    public void setPassword(String password){
        (getDriver().findElement(By.id(idpasswd))).sendKeys(password);
        (getDriver().findElement(By.id(id_days))).sendKeys("28");
        (getDriver().findElement(By.id(id_months))).sendKeys("September");
        (getDriver().findElement(By.id(id_years))).sendKeys("1996");
        Serenity.takeScreenshot();

    }

    @Step ("Cliente ingresa datos de su domicilio")
    public void setDataDelivery(){
        (getDriver().findElement(By.id(id_company))).sendKeys(companyName);
        (getDriver().findElement(By.id(id_address1))).sendKeys("Av. Tomas Maresano 1112 - Surquillo");
        (getDriver().findElement(By.id(id_address2))).sendKeys("Av. La Magnolia 261 - Surquillo");
        (getDriver().findElement(By.id(id_city))).sendKeys("Lima");
        (getDriver().findElement(By.id(id_state))).sendKeys("Texas");
        (getDriver().findElement(By.id(id_postcode))).sendKeys("00000");
        (getDriver().findElement(By.id(id_other))).sendKeys("Prueba Automatizada Jorge Baca");
        (getDriver().findElement(By.id(id_phone))).sendKeys("555555");
        (getDriver().findElement(By.id(id_phone_mobile))).sendKeys(phone);
        (getDriver().findElement(By.id(id_alias))).clear();
        (getDriver().findElement(By.id(id_alias))).sendKeys("Surquillo - Av. Manuel Villaran");
        Serenity.takeScreenshot();
        (getDriver().findElement(By.id(buttonRegistryConfirm))).click();

    }
    @Step ("Verificando nombre del cliente")
    public void verifyUser(){
        getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
        fullname=(getDriver().findElement(By.className(verifyAccount))).getText();
        String fullNameInput=PayStepDefinition.name+" "+PayStepDefinition.last_name;
        assertThat(fullname, equalTo(fullNameInput));

    }
    @Step("Seleccionando Categoria del Producto")
    public void selectCategory()
    {
        (getDriver().findElement(By.className("sf-with-ul"))).click();
        Util.waitFor(5);
    }
    @Step("Seleccionando Primer Producto")
    public void selectProductOne(){
        getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        (getDriver().findElement(By.xpath(firstProduct))).click();
        Util.waitFor(5);
        getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        titleProduct1=(getDriver().findElement(By.xpath(titleProduct))).getText();
        priceProduct1=(getDriver().findElement(By.id(priceProduct))).getText();
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(buttonAddCart))).click();
        Util.waitFor(5);
        getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(buttonContinueAdd))).click();
        Util.waitFor(5);

    }
    @Step("Seleccionando segundo producto")
    public void selectProductSecond(){
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        (getDriver().findElement(By.xpath(selectCategory3))).click();
        Util.waitFor(5);
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
        Util.waitFor(2);
        (getDriver().findElement(By.xpath(product2))).click();
        Util.waitFor(5);
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        titleProduct2=(getDriver().findElement(By.xpath(getTitleProduct2))).getText();
        priceProduct2=(getDriver().findElement(By.id(getPriceProduct2))).getText();
        Serenity.takeScreenshot();
        (getDriver().findElement(By.id(buttonAddtoCardID))).click();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(confirmCart))).click();
        Util.waitFor(12);
    }
    @Step("Verificando datos de entrega")
    public void confirmBuy(){
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        (getDriver().findElement(By.xpath(continueBuy))).click();
        Util.waitFor(5);
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String directionCompany=(getDriver().findElement(By.className(address_company))).getText();
        String phonemobileDetails=(getDriver().findElement(By.className(address_phone_mobile))).getText();
        assertThat(companyName, equalTo(directionCompany));
        assertThat(phone,equalTo(phonemobileDetails));
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(buttonConfirmed))).click();
        Util.waitFor(5);


    }

    @Step("Verificando datos finales de la compra")
    public void verifyDetails(){
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        (getDriver().findElement(By.id(checkboxConfirmed))).click();
        Util.waitFor(5);
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(confirmPayment))).click();
        Util.waitFor(5);
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
    }

}