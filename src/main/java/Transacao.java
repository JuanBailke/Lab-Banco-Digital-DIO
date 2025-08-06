import lombok.Getter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Transacao {
    private final LocalDateTime data;
    private final TipoTransacao tipo;
    private final double valor;
    private final String descricao;

    private static final DateTimeFormatter FORMATADOR_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Transacao(TipoTransacao tipo, double valor, String descricao) {
        this.data = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("%s - %-25s - R$ %.2f - %s",
                data.format(FORMATADOR_DATA_HORA), tipo, valor, descricao);
    }
}