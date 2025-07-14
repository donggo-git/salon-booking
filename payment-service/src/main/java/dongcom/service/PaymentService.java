package dongcom.service;

import dongcom.domain.PaymentMethod;
import dongcom.modal.PaymentOrder;
import dongcom.payload.PaymentLinkResponse;
import dongcom.payload.payload_dto.UserDTO;
import dongcom.payload.payload_dto.BookingDTO;

import com.razorpay.PaymentLink;

public interface PaymentService {
    PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id);

    PaymentOrder getPaymentOrderByPaymentId(String paymentId);

    PaymentLink createRazorPaymentLink(UserDTO user, Long amount, Long orderId);
}
