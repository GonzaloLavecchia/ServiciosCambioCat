package ServiciosCambioCat;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Categorias {

    /* Servicio que recupera el listado de categorias pertenecientes a una cuenta */
    private String cuenta = "101604";
    private HttpUriRequest request = new HttpGet("http://servicios.externos.testing.gov.ar/Cognisys/cambioCategoria/categorias/" + cuenta);

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
     * Caso de prueba que verifica que el listado devuelto por el servicio sea correcto.
     * RESULTADO ESPERADO: lista de categorias.
     */
    @Test
    public void getListaCategorias() {

        // TODO
        List<String> actual = Arrays.asList("1", "2", "3");
        List<String> expected = Arrays.asList("1", "2", "3");

        assertThat(actual, is(expected));

    }

    /**
     * Caso de prueba que verifica que en el listado devuelto por el servicio no se muestre la categoria en la que ya se encuentra.
     * RESULTADO ESPERADO: la categoria no debe aparecer en el listado.
     */
    @Test
    public void validarCategoriaActual() {

        // TODO
    }

}
