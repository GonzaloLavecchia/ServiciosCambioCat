package ServiciosCambioCat;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Datos {

    /* Servicio que recupera la categoria actual y la fecha a partir de una cuenta */
    private String cuenta = "101604";
    private HttpUriRequest request = new HttpGet("http://servicios.externos.testing.gov.ar/Cognisys/cambioCategoria/datos/" + cuenta);

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

    /**
     * Caso de prueba que verifica que la categoria devuelta por el servicio sea correcta.
     * RESULTADO ESPERADO: categoriaEsperada
     */
    @Test
    public void getCategoria() {

        // TODO

        /* Resultado esperado */
        String categoriaEsperada = "";
        String categoriaActual = "";
        assertEquals(categoriaEsperada, categoriaActual);
    }

    /**
     * Caso de prueba que verifica que la fecha devuelta por el servicio sea correcta.
     * RESULTADO ESPERADO: fechaEsperada
     */
    @Test
    public void getFecha() {

        // TODO

        /* Resultado esperado */
        String fechaEsperada = "";
        String fechaActual = "";
        assertEquals(fechaEsperada, fechaActual);
    }


}
