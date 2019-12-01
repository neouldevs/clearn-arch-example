package com.github.hyeyoom.usecase.core;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public interface UseCaseExecutor<REQ_DTO, RES_DTO, REQ, RES> {

    CompletionStage<RES_DTO> invoke(
            UseCase<REQ, RES> useCase,
            REQ_DTO requestDto,
            Function<REQ_DTO, REQ> requestConverter,
            Function<RES_DTO, RES> responseConverter
     );
}
