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

    public List<Endereco> paraListaEnderecoEntity(List<EnderecoDTO> dtos) {
        return dtos.stream().map(this::paraEnderecoEntity).toList();
    }

    public Endereco paraEnderecoEntity(EnderecoDTO dto) {
        return Endereco.builder()
                .rua(dto.getRua())
                .numero(dto.getNumero())
                .complemento(dto.getComplemento())
                .cidade(dto.getCidade())
                .estado(dto.getEstado())
                .cep(dto.getCep())
                .build();
    }

    public List<Telefone> paraListaTelefoneEntity(List<TelefoneDTO> dtos) {
        return dtos.stream().map(this::paraTelefoneEntity).toList();
    }

    public Telefone paraTelefoneEntity(TelefoneDTO dto) {
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

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> entidades) {
        return entidades.stream().map(this::paraEnderecoDTO).toList();
    }

    public EnderecoDTO paraEnderecoDTO(Endereco entidade) {
        return EnderecoDTO.builder()
                .id(entidade.getId())
                .rua(entidade.getRua())
                .numero(entidade.getNumero())
                .complemento(entidade.getComplemento())
                .cidade(entidade.getCidade())
                .estado(entidade.getEstado())
                .cep(entidade.getCep())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> entidades) {
        return entidades.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone entidade) {
        return TelefoneDTO.builder()
                .id(entidade.getId())
                .numero(entidade.getNumero())
                .ddd(entidade.getDdd())
                .build();
    }

    public Usuario atualizarUsuario(UsuarioDTO usuarioDTO, Usuario entity){
        return Usuario.builder()
                .nome(usuarioDTO.getNome() != null ? usuarioDTO.getNome() : entity.getNome())
                .id(entity.getId())
                .email(usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : entity.getEmail())
                .senha(usuarioDTO.getSenha() != null ? usuarioDTO.getSenha() : entity.getSenha())
                .enderecos(entity.getEnderecos())
                .telefones(entity.getTelefones())
                .build();
    }

    public Endereco atualizarEndereco(EnderecoDTO enderecoDTO, Endereco entity){
        return Endereco.builder()
                .id(entity.getId())
                .rua(enderecoDTO.getRua() != null ? enderecoDTO.getRua() : entity.getRua())
                .numero(enderecoDTO.getNumero() != null ? enderecoDTO.getNumero() : entity.getNumero())
                .complemento(enderecoDTO.getComplemento() != null ? enderecoDTO.getComplemento() : entity.getComplemento())
                .cidade(enderecoDTO.getCidade() != null ? enderecoDTO.getCidade() : entity.getCidade())
                .estado(enderecoDTO.getEstado() != null ? enderecoDTO.getEstado() : entity.getEstado())
                .cep(enderecoDTO.getCep() != null ? enderecoDTO.getCep() : entity.getCep())
                .build();
    }
    public Telefone atualizarTelefone(TelefoneDTO telefoneDTO, Telefone entity){
        return Telefone.builder()
                .id(entity.getId())
                .numero(telefoneDTO.getNumero() != null ? telefoneDTO.getNumero() : entity.getNumero())
                .ddd(telefoneDTO.getDdd() != null ? telefoneDTO.getDdd() : entity.getDdd())
                .build();
    }
}