package payload;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/** Serializes booleans as 0/1. */
public class NumericBooleanSerializer extends JsonSerializer<Boolean> {
    @Override
    public void serialize(Boolean value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(value ? 1 : 0);
    }
}