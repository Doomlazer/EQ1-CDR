;;; Sierra Script 1.0 - (do not remove this comment)
(script# 823)
(include sci.sh)
(use Slider)
(use GameControls)


(class EcoSlider of Slider
	(properties
		view -1
		loop -1
		cel -1
		nsLeft 0
		nsTop -1
		nsRight 0
		nsBottom 0
		state $0000
		cursor -1
		type $4000
		message -1
		modifiers $0000
		signal $0001
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
		sliderView 0
		sliderLoop 0
		sliderCel 0
		sTop 0
		sLeft 0
		sRight 0
		maxY 0
		minY 0
		underBits 0
		yStep 1
		theObj 0
		selector 0
		bottomValue 0
		topValue 0
		helpStr 0
	)
)

(class EcoControlIcon of ControlIcon
	(properties
		view -1
		loop -1
		cel -1
		nsLeft 0
		nsTop -1
		nsRight 0
		nsBottom 0
		state $0000
		cursor -1
		type $4000
		message -1
		modifiers $0000
		signal $0001
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
		theObj 0
		selector 0
		helpStr 0
	)
)
