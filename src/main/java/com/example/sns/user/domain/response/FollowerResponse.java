package com.example.sns.user.domain.response;
import com.example.sns.user.domain.dto.FollowerDto;
        import com.example.sns.user.domain.entity.Follower;
        import lombok.*;
        import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FollowerResponse extends FollowerDto {
    private Long id;
    public FollowerResponse(Follower follower) {
        super(follower);
    }

    public FollowerResponse(){

    }

}
