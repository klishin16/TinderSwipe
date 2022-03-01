package com.example.tinder.ui.home

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.tinder.databinding.FragmentHomeBinding
import android.animation.AnimatorSet
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.cardview.widget.CardView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tinder.R
import java.util.*
import kotlin.concurrent.schedule


data class Car(val name: String, val url: String)

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel: SwipeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var expandText = false
    private var expandTextClickCheck = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val carsList = (0..5).map {
            Car("Toyota Supra", "111")
        }

        Log.i("HomeFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(SwipeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val likeButton: ImageButton = binding.likeBtn
        val dislikeButton: ImageButton = binding.dislikeBtn

        likeButton.setOnClickListener {
            likeAnimation(iBtn = likeButton)
            binding.motionLayout.transitionToState(R.id.dislike)
        }

        dislikeButton.setOnClickListener {
            dislikeAnimation(iBtn = dislikeButton)
            binding.motionLayout.transitionToState(R.id.like)
        }

        updateTopCard(viewModel.getTopCard())
        updateBottomCard(viewModel.getBottomCard())

        binding.motionLayout.setTransitionListener(object : TransitionAdapter() {

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.offScreenDislike -> {
                        viewModel.swipe()
                        updateTopCard(viewModel.getTopCard())
                        updateBottomCard(viewModel.getBottomCard())
                    }
                    R.id.offScreenLike -> {
                        viewModel.swipe()
                        updateTopCard(viewModel.getTopCard())
                        updateBottomCard(viewModel.getBottomCard())
                    }
                    R.id.offSwipeTop -> {
                        viewModel.swipe()
                        updateTopCard(viewModel.getTopCard())
                        updateBottomCard(viewModel.getBottomCard())
                    }
                }
            }

        })

        binding.topCardSubtext.setOnClickListener {
            Log.i("HomeFragment", "Expand text")
            if (expandTextClickCheck) {
                expandText = !expandText
                expandTextClickCheck = false
                if (expandText) {
                    binding.topCardSubtext.maxLines = 100
                } else {
                    binding.topCardSubtext.maxLines = 2
                }
            } else {
                expandTextClickCheck = true
            }

        }


        return root
    }

    private fun likeAnimation(iBtn: ImageButton) {
        val animator11 = ObjectAnimator.ofFloat(iBtn, View.SCALE_X, 1f, 1.2f)
        val animator12 = ObjectAnimator.ofFloat(iBtn, View.SCALE_Y, 1f, 1.2f)
        animator11.duration = 140
        animator12.duration = 140

        val animator2 = ObjectAnimator.ofFloat(iBtn, View.ALPHA, 1f, 0f, 1f)
        animator2.duration = 200

        val animator31 = ObjectAnimator.ofFloat(iBtn, View.SCALE_X, 1.2f, 1.0f)
        val animator32 = ObjectAnimator.ofFloat(iBtn, View.SCALE_Y, 1.2f, 1.0f)
        animator31.duration = 140
        animator32.duration = 140

        val set = AnimatorSet()
        set.play(animator11).before(animator2)
        set.play(animator12).before(animator2)
        set.play(animator2).before(animator31)
        set.play(animator2).before(animator32)
        set.start()
    }

    private fun dislikeAnimation(iBtn: ImageButton) {
        val animator11 = ObjectAnimator.ofFloat(iBtn, View.SCALE_X, 1f, 1.2f)
        val animator12 = ObjectAnimator.ofFloat(iBtn, View.SCALE_Y, 1f, 1.2f)
        animator11.duration = 140
        animator12.duration = 140

        val animator2 = ObjectAnimator.ofFloat(iBtn, View.ALPHA, 1f, 0f, 1f)
        animator2.duration = 200

        val animator31 = ObjectAnimator.ofFloat(iBtn, View.SCALE_X, 1.2f, 1.0f)
        val animator32 = ObjectAnimator.ofFloat(iBtn, View.SCALE_Y, 1.2f, 1.0f)
        animator31.duration = 140
        animator32.duration = 140

        val set = AnimatorSet()
        set.play(animator11).before(animator2)
        set.play(animator12).before(animator2)
        set.play(animator2).before(animator31)
        set.play(animator2).before(animator32)
        set.start()
    }


    /** Methods for updating the UI **/

    private fun updateTopCard(cardModel: SwipeCardModel) {
        binding.topCardText.text = cardModel.cardText
        binding.topCardImage.setImageResource(cardModel.image)
    }

    private fun updateBottomCard(cardModel: SwipeCardModel) {
        binding.bottomCardText.text = cardModel.cardText
        binding.bottomCardImage.setImageResource(cardModel.image)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}