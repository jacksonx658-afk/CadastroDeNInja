package dev.java10x.CadastrosDeNinjas.Missoes;


import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "tb_missoes")

public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;
    // @OneToMany uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;
}