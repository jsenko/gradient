package net.jsenko.pv260.gradient.cli;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Jakub Senko
 */
public class CLITest {


    @Test
    public void itShouldCallDisplaySuccessfully() {
        InputStream in = new ByteArrayInputStream(
                "10 10\n .:#\nradial 0 0 10\n".getBytes(StandardCharsets.UTF_8));

        Handler handler = mock(Handler.class);
        new CLI(handler).run(in);

        verify(handler).radial(0, 0, 10);
    }
}
