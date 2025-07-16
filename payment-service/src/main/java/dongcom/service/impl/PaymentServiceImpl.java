package dongcom.service.impl;

import org.springframework.stereotype.Service;

import com.razorpay.PaymentLink;

import dongcom.domain.PaymentMethod;
import dongcom.modal.PaymentOrder;
import dongcom.payload.PaymentLinkResponse;
import dongcom.payload.payload_dto.BookingDTO;
import dongcom.payload.payload_dto.UserDTO;
import dongcom.repository.PaymentOrderRepository;
import dongcom.service.PaymentService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentOrderRepository paymentOrderRepository;

    @Override
    public PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentOrderById'");
    }

    @Override
    public PaymentOrder getPaymentOrderByPaymentId(String paymentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentOrderByPaymentId'");
    }

    @Override
    public PaymentLink createRazorPaymentLink(UserDTO user, Long amount, Long orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRazorPaymentLink'");
    }

    @Override
    public String createStripePaymentLink(UserDTO user, Long amount, Long orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createStripePaymentLink'");
    }

}
