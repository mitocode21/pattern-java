package com.mitocode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    private static void check(){
        String text = "ese mito";
        //boolean isChecked = text.matches("es");
        //boolean isChecked = text.matches("(es|ef)");
        //boolean isChecked = text.matches("es|ef");
        boolean isChecked = text.matches(".*es.*");
        System.out.println(isChecked);
    }

    private static void checkEmail() {
        String email = "ejemplo@dominio.com";
        boolean isEmailValid = email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        System.out.println(isEmailValid);

        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("La cadena de texto es una dirección de correo electrónico válida.");
        } else {
            System.out.println("La cadena de texto no es una dirección de correo electrónico válida.");
        }
    }

    private static void checkMatchvsFind(){
        String text = "hola123mundo";
        Pattern pattern = Pattern.compile("\\d+"); //  \d para expresar cualquiera digito y + uno o mas coincidencias
        Matcher matcher = pattern.matcher(text);

        System.out.println(matcher.matches());
        System.out.println(matcher.find());
    }

    private static void checkIp() {
        String ipAddress = "192.168.1.1";
        boolean isIpAddressValid = ipAddress.matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
        System.out.println(isIpAddressValid);
    }

    private static void checkPhoneNumber() {
        String phoneNumber = "+1 (555) 123-4567";
        boolean isPhoneNumberValid = phoneNumber.matches("\\+\\d{1,2}\\s\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
        System.out.println(isPhoneNumberValid);
    }

    private static void checkTextInText() {
        String text = "Hola Coders suscribanse al canal!";
        String pattern = "canal";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println("Encontrado en la posición " + m.start() + " a " + (m.end() - 1));
        }
    }

    private static void replaceAllInTextInText() {
        String text = "Hola Coders suscribanse al canal!";
        String pattern = "canal";
        String replaceWith = "canal de youtube";
        String newText = text.replaceAll(pattern, replaceWith);
        System.out.println(newText);
    }

    private static void checkEmailAndExtract() {
        String email = "mitocode@dominio.com";
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            String username = matcher.group(1);
            String domain = matcher.group(2);
            System.out.println("Nombre de usuario: " + username);
            System.out.println("Dominio: " + domain);
        }
    }

    //verificar si una palabra contiene letra repetida dos veces o más
    private static void checkWords(){
        String input = "Esta es una cadena de texto de ejemploo.";
        Pattern pattern = Pattern.compile("\\b(\\w*(\\w)\\2\\w*)\\b");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Palabra encontrada: " + matcher.group(1));
        }

    }

    private static void checkPassword() {
        //Al menos 1 mayuscula, 1 minuscula, 1 numero y 1 caracter especial
        String password = "MitoCo1!";
        boolean isPasswordValid = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\d\\s]).+$");


        System.out.println(isPasswordValid);
    }

    public static void main(String[] args) {
        App.checkPassword();

        //Número de teléfono: \+?\d{1,3}[-.\s]?\(?\d{3}\)?[-.\s]?\d{3}[-.\s]?\d{4}
        //Dirección IP: \b(?:\d{1,3}\.){3}\d{1,3}\b
        //Contraseña: ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$

        //Nombres de archivos: [^/\\&\?]+\.\w{3,4}(?=([\?&].*$|$))
        //Direcciones URL: ^(https?|ftp)://[^\s/$.?#].[^\s]*$
        //Etiquetas HTML: <([a-z]+)([^<]+)*(?:>(.*)<\/\1>|\s+\/>)

        // a = buscara exactamente la letra a
        // abc = buscara exactamente la palabra abc
        // (abc|def) = buscara la cadena abc o def
        //[abc] = buscara que la cadena contenga a b o c
        // . (un punto) = cualquier caracter
        // * = buscar cero o más ocurrencias
        // + = buscar uno a más coincidencias
        // ? = cero o una ocurrencia del patrón anterior
        // {n} = exactamente n ocurrencias del patron anterior
    }
}
