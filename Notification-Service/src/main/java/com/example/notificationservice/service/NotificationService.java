package com.example.notificationservice.service;

import com.example.notificationservice.dto.UserEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user-service.url}")
    private String userServiceUrl;

    public String getEmailOfUser(Long userId) {
        try {
            UserEmailDTO user = restTemplate.getForObject(
                    userServiceUrl + "/api/v1/internal/users/" + userId,
                    UserEmailDTO.class);
            assert user != null;
            return user.getEmail();
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Không tìm thấy user id = " + userId);
        } catch (ResourceAccessException e) {
            throw new RuntimeException("Không kết nối được user-service");
        }
    }

    public String sendNotification(Long userId, String message) {
        String email = getEmailOfUser(userId);
        // Giả lập gửi mail: thực tế sẽ gọi dịch vụ email
        return "Đã gửi '" + message + "' tới " + email;
    }
}
