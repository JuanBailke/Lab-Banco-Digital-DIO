import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Cliente {

    @NonNull
    private String nome;
    @NonNull
    private String cpf;
}
