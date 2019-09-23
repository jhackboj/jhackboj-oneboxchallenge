package es.onebox.exercise.trains.file;

import java.io.File;

/**
 * Provides a general interface to read inputs files. Each
 * implementation should use {@link File} and return {@link InputModel}.
 *
 * @author "Jose Luis Sanchez Boj <joselsb3@gmail.com>"
 *
 */
public interface InputProviderService
{
    InputModel read(File file) throws Exception;
}
