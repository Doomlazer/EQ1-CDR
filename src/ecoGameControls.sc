;;; Sierra Script 1.0 - (do not remove this comment)
(script# 822)
(include sci.sh)
(use Main)
(use EcoFeature)
(use EcoSlider)
(use GameControls)
(use SysWindow)

(public
	ecoGameControls 0
)

(instance ecoGameControls of GameControls
	(properties)
	
	(method (init)
		(= gGameControls self)
		(self
			add:
				(iconSave theObj: gGame selector: 75 yourself:)
				(iconRestore theObj: gGame selector: 76 yourself:)
				(iconRestart theObj: gGame selector: 101 yourself:)
				(volumeSlider
					theObj: gGame
					selector: 380
					topValue: (if (> global103 1) 15 else 1)
					bottomValue: 0
					yourself:
				)
				(speedSlider
					theObj: (ScriptID 0 12)
					selector: 57
					topValue: 1
					bottomValue: 15
					yourself:
				)
				(detailSlider
					theObj: gGame
					selector: 299
					topValue: 3
					bottomValue: 0
					yourself:
				)
				iconOk
				(iconAbout theObj: gGame selector: 667 yourself:)
				(iconHelp cursor: (ScriptID 0 10))
				(iconQuit theObj: gGame selector: 100 yourself:)
				(iconTextSwitch
					theObj: iconTextSwitch
					selector: 57
					yourself:
				)
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			helpIconItem: iconHelp
			curIcon: iconRestore
			window: gcWin
		)
		(gcWin color: global224 back: global224)
		(super init: &rest)
	)
	
	(method (dispose)
		(super dispose:)
		(gGame setCursor: gArrowC)
		(DisposeScript 823)
		(DisposeScript 934)
		(DisposeScript 978)
		(DisposeScript 822)
	)
	
	(method (show)
		(gGame setCursor: 999)
		(super show: &rest)
	)
)

(instance gcWin of SysWindow
	(properties)
	
	(method (open &tmp [temp0 22])
		(self
			top: 30
			left: 74
			bottom: 149
			right: 263
			priority: 15
		)
		(super open:)
		(DrawCel 952 8 0 0 0 15)
	)
)

(instance detailSlider of EcoSlider
	(properties
		view 952
		loop 7
		cel 0
		nsLeft 132
		nsTop 35
		signal $0080
		noun 1
		helpVerb 59
		sliderView 952
		sliderLoop 7
		sliderCel 1
		topValue 3
		helpStr 25
	)
)

(instance volumeSlider of EcoSlider
	(properties
		view 952
		loop 7
		cel 0
		nsLeft 17
		nsTop 35
		signal $0080
		noun 1
		helpVerb 61
		sliderView 952
		sliderLoop 7
		sliderCel 1
		topValue 15
		helpStr 26
	)
)

(instance speedSlider of EcoSlider
	(properties
		view 952
		loop 7
		cel 0
		nsLeft 78
		nsTop 25
		signal $0080
		noun 1
		helpVerb 60
		sliderView 952
		sliderLoop 7
		sliderCel 1
		bottomValue 15
		helpStr 27
	)
)

(instance iconSave of EcoControlIcon
	(properties
		view 952
		loop 0
		cel 0
		nsLeft 12
		nsTop 9
		message 8
		signal $01c3
		noun 1
		helpVerb 62
		helpStr 28
	)
)

(instance iconRestore of EcoControlIcon
	(properties
		view 952
		loop 1
		cel 0
		nsLeft 54
		nsTop 9
		message 8
		signal $01c3
		noun 1
		helpVerb 67
		helpStr 29
	)
)

(instance iconRestart of EcoControlIcon
	(properties
		view 952
		loop 2
		cel 0
		nsLeft 119
		nsTop 9
		message 8
		signal $01c3
		noun 1
		helpVerb 63
		helpStr 30
	)
)

(instance iconQuit of EcoControlIcon
	(properties
		view 952
		loop 6
		cel 0
		nsLeft 141
		nsTop 78
		message 8
		signal $01c3
		noun 1
		helpVerb 64
		helpStr 31
	)
)

(instance iconAbout of EcoControlIcon
	(properties
		view 952
		loop 4
		cel 0
		nsLeft 66
		nsTop 78
		message 8
		signal $01c3
		noun 1
		helpVerb 65
		helpStr 32
	)
)

(instance iconHelp of EcoIconItem
	(properties
		view 952
		loop 5
		cel 0
		nsLeft 103
		nsTop 78
		message 8
		signal $0183
		noun 1
		helpVerb 54
	)
	
	(method (init)
		(= cursor (ScriptID 0 10))
		(super init: &rest)
	)
)

(instance iconTextSwitch of EcoControlIcon
	(properties
		view 952
		loop 9
		cel 0
		nsLeft 42
		nsTop 97
		message 8
		signal $0183
		noun 1
		helpVerb 68
	)
	
	(method (doit)
		(switch global90
			(1 (= global90 2))
			(2 (= global90 3))
			(3 (= global90 1))
		)
		(self show:)
	)
	
	(method (show)
		(switch global90
			(1
				(= global83 0)
				(DrawCel 952 10 0 100 97 -1)
			)
			(2
				(= global83 1)
				(DrawCel 952 10 1 100 97 -1)
			)
			(3
				(= global83 1)
				(DrawCel 952 10 2 100 97 -1)
			)
		)
		(Graph
			grUPDATE_BOX
			97
			100
			(+ 97 (CelHigh 952 10))
			(+ 100 (CelWide 952 10))
			1
		)
		(super show: &rest)
	)
)

(instance iconOk of EcoIconItem
	(properties
		view 952
		loop 3
		cel 0
		nsLeft 12
		nsTop 78
		message 8
		signal $01c3
		noun 1
		helpVerb 66
		helpStr 33
	)
	
	(method (init)
		(= cursor (ScriptID 0 8))
		(super init: &rest)
	)
)
