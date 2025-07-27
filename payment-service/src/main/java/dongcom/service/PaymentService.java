package dongcom.service;

import dongcom.domain.PaymentMethod;
import dongcom.modal.PaymentOrder;
import dongcom.payload.PaymentLinkResponse;
import dongcom.payload.payload_dto.UserDTO;
import dongcom.payload.payload_dto.BookingDTO;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;

public interface PaymentService {
    PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    PaymentOrder getPaymentOrderByPaymentId(String paymentId) throws Exception;

    PaymentLink createRazorPaymentLink(UserDTO user, Long amount, Long orderId)
            throws RazorpayException;

    String createStripePaymentLink(UserDTO user, Long amount, Long orderId);
}
