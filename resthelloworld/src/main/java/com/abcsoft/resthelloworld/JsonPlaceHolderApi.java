package com.abcsoft.resthelloworld;

        import com.abcsoft.resthelloworld.model.Comment;
        import com.abcsoft.resthelloworld.model.Post;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.Path;
        import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Call<List<Comment>> getCommnets(@Path("id") int postId);

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);

    @POST("Posts")
    Call<Post> createPost(@Body Post post);

}