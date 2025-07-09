package dongcom.service;

import dongcom.domain.PaymentMethod;
import dongcom.payload.PaymentLinkResponse;
import dongcom.payload.payload_dto.UserDTO;
import dongcom.payload.payload_dto.BookingDTO;

public interface PaymentService {
    PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod);
}
