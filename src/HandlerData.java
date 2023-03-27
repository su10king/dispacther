import com.sun.tracing.dtrace.Attributes;
import org.simpleframework.xml.Attribute;

@Root
public class HandlerData {
    @Attributes(required=false)
    private String header;

    @Text
    private String text;

    public String getHeader() {
        return header;
    }

    public String getHandler() {
        return text;
    }
}
