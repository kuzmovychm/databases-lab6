package ua.lviv.iot.lab6.mapper;

public interface GeneralMapper<M, D> {

    D convertToDto(M model);

    M convertToModel(D dto);

}
