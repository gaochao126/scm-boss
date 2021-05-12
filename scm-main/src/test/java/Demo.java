import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Demo implements Serializable {
    private static final long serialVersionUID = 1724474519222652095L;

    private String name;

    private String totalAmt;

    private BigDecimal amt;
}
