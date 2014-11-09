package fr.gouv.vitam.schema;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Utility class to serialize FileId to simple String
 *
 */
public class FileIdSerializer extends JsonSerializer<FileId> {

    @Override
    public void serialize(FileId value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
            JsonProcessingException {
        jgen.writeString(value.id);
    }
}
