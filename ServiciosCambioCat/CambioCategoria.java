package ServiciosCambioCat;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CambioCategoria {

    /* Servicio que realiza el cambio de categoria */
    private String cuenta = "101604/";
    private String tramite = "1001";
    private HttpUriRequest request = new HttpPost("http://servicios.externos.testing.gov.ar/Cognisys/cambioCategoria/finalizar/" + cuenta + tramite);

    /**
     * Caso de prueba que verifica si el codigo del request es 200.
     * RESULTADO ESPERADO: 200.
     *
     * @throws IOException
     */
    @Test
    public void getStatus200() throws IOException {
        System.out.println("Ejecutando servicio...");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        /* Resultado esperado */
        System.out.println("Verificando status del request...");
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    /**
     * Caso de prueba que verifica si el mensaje del request es OK.
     * RESULTADO ESPERADO: OK.
     *
     * @throws IOException
     */
    @Test
    public void getMessageOK() throws IOException {
        System.out.println("Ejecutando servicio...");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        /* Resultado esperado */
        System.out.println("Verificando mensaje del request...");
        assertThat(httpResponse.getStatusLine().getReasonPhrase(), equalTo("OK"));
    }

    /**
     * Caso de prueba que verifica si el codigo del request es 500.
     * RESULTADO ESPERADO: 500.
     *
     * @throws IOException
     */
    @Test
    public void getStatus503() throws IOException {
        System.out.println("Ejecutando servicio...");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        /* Resultado esperado */
        System.out.println("Verificando status del request...");
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_SERVICE_UNAVAILABLE));
    }

    /**
     * Caso de prueba que verifica si el mensaje del request es Service Unavailable.
     * RESULTADO ESPERADO: Service Unavailable.
     *
     * @throws IOException
     */
    @Test
    public void getMessageServiceUnavailable() throws IOException {
        System.out.println("Ejecutando servicio...");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        /* Resultado esperado */
        System.out.println("Verificando mensaje del request...");
        assertThat(httpResponse.getStatusLine().getReasonPhrase(), equalTo("Service Unavailable"));
    }

    /**
     * Caso de prueba que verifica si el codigo del request es 404.
     * RESULTADO ESPERADO: 404.
     *
     * @throws IOException
     */
    @Test
    public void getStatus404() throws IOException {
        System.out.println("Ejecutando servicio...");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        /* Resultado esperado */
        System.out.println("Verificando status del request...");
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    /**
     * Caso de prueba que verifica si el mensaje del request es Not Found.
     * RESULTADO ESPERADO: Not Found.
     *
     * @throws IOException
     */
    @Test
    public void getMessageNotFound() throws IOException {
        System.out.println("Ejecutando servicio...");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        /* Resultado esperado */
        System.out.println("Verificando mensaje del request...");
        assertThat(httpResponse.getStatusLine().getReasonPhrase(), equalTo("Not Found"));
    }


}
