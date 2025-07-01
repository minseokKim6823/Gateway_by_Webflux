// Swagger UI 초기화 설정
window.onload = function() {
  // Swagger UI 인스턴스가 로드된 후 실행
  const checkSwaggerUI = setInterval(() => {
    if (window.ui) {
      // 기본 서버 설정
      const servers = [
        {
          url: "http://localhost:8080/spring",
          description: "Spring WAS via Gateway"
        },
        {
          url: "http://localhost:8080/fastapi", 
          description: "FastAPI via Gateway"
        }
      ];

      // 커스텀 CSS 적용
      const style = document.createElement('style');
      style.innerHTML = `
        .swagger-ui .topbar { display: none; }
        .swagger-ui .info { margin: 50px 0; }
        .swagger-ui .scheme-container { 
          background: #fafafa; 
          padding: 10px; 
          border-radius: 4px; 
        }
      `;
      document.head.appendChild(style);

      // API 선택 시 기본 서버 설정
      window.ui.preauthorizeApiKey = function(apiKeyAuth, value) {
        // API Key 인증 처리
        console.log('API Key authorized:', apiKeyAuth, value);
      };

      clearInterval(checkSwaggerUI);
    }
  }, 100);
};

// 유틸리티 함수들
const SwaggerUtils = {
  // API 응답 후처리
  postProcessResponse: function(response) {
    console.log('API Response:', response);
    return response;
  },

  // 요청 전처리  
  preProcessRequest: function(request) {
    console.log('API Request:', request);
    return request;
  },

  // 에러 핸들링
  handleError: function(error) {
    console.error('Swagger Error:', error);
    alert('API 호출 중 오류가 발생했습니다: ' + error.message);
  }
};
