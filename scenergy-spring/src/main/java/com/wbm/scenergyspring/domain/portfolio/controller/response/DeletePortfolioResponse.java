package com.wbm.scenergyspring.domain.portfolio.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeletePortfolioResponse {
	Long portfolioId;
}