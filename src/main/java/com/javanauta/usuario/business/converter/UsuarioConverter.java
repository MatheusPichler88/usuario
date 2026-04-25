package com.javanauta.usuario.business.converter;

import com.javanauta.usuario.business.dto.EnderecoDTO;
import com.javanauta.usuario.business.dto.TelefoneDTO;
import com.javanauta.usuario.business.dto.UsuarioDTO;
import com.javanauta.usuario.infrastructure.entity.Endereco;
import com.javanauta.usuario.infrastructure.entity.Telefone;
import com.javanauta.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    // === DTO para ENTITY ===

    public Usuario paraUsuario(UsuarioDTO dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .enderecos(paraListaEnderecoEntity(dto.getEnderecos()))
                .telefones(paraListaTelefoneEntity(dto.getTelefones()))
                .build();
    }

    private List<Endereco> paraListaEnderecoEntity(List<EnderecoDTO> dtos) {
        return dtos.stream().map(this::paraEnderecoEntity).toList();
    }

    private Endereco paraEnderecoEntity(EnderecoDTO dto) {
        return Endereco.builder()
                .rua(dto.getRua())
                .numero(dto.getNumero())
                .complemento(dto.getComplemento())
                .cidade(dto.getCidade())
                .estado(dto.getEstado())
                .cep(dto.getCep())
                .build();
    }

    private List<Telefone> paraListaTelefoneEntity(List<TelefoneDTO> dtos) {
        return dtos.stream().map(this::paraTelefoneEntity).toList();
    }

    private Telefone paraTelefoneEntity(TelefoneDTO dto) {
        return Telefone.builder()
                .numero(dto.getNumero())
                .ddd(dto.getDdd())
                .build();
    }

    // === ENTITY para DTO ===

    public UsuarioDTO paraUsuarioDTO(Usuario entidade) {
        return UsuarioDTO.builder()
                .nome(entidade.getNome())
                .email(entidade.getEmail())
                .senha(entidade.getSenha())
                .enderecos(paraListaEnderecoDTO(entidade.getEnderecos()))
                .telefones(paraListaTelefoneDTO(entidade.getTelefones()))
                .build();
    }

    private List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> entidades) {
        return entidades.stream().map(this::paraEnderecoDTO).toList();
    }

    private EnderecoDTO paraEnderecoDTO(Endereco entidade) {
        return EnderecoDTO.builder()
                .rua(entidade.getRua())
                .numero(entidade.getNumero())
                .complemento(entidade.getComplemento())
                .cidade(entidade.getCidade())
                .estado(entidade.getEstado())
                .cep(entidade.getCep())
                .build();
    }

    private List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> entidades) {
        return entidades.stream().map(this::paraTelefoneDTO).toList();
    }

    private TelefoneDTO paraTelefoneDTO(Telefone entidade) {
        return TelefoneDTO.builder()
                .numero(entidade.getNumero())
                .ddd(entidade.getDdd())
                .build();
    }
}