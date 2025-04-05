package com.photo.album.converter;

public interface IGenericConverter<E, D> {
    D convertFromEntityToDTO(E entity);
}
