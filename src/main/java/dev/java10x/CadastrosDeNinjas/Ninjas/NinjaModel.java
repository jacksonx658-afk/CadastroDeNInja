package dev.java10x.CadastrosDeNinjas.Ninjas;

import dev.java10x.CadastrosDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "tb_cadastro")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id") // Chave estrangeira no banco de dados
    private MissoesModel missoes;

}
